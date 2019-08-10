package imageCompare

import java.awt.image.BufferedImage
import java.io.File
import java.text.DecimalFormat

import com.typesafe.scalalogging.LazyLogging
import javax.imageio.ImageIO

case class ImageWithMeta(imageName: String, image: BufferedImage)

object ImageCompareService extends LazyLogging {

  def compare(): Unit = {
    val startTime = System.currentTimeMillis()
    logger.info("Starting image comparison")

    val result = checkDiffPercentage(getImages)

    val endTime = System.currentTimeMillis()
    logger.info(s"Diff check took ${endTime - startTime}ms")
    logger.info(s"result: $result")
  }

  private def getImages: Seq[ImageWithMeta] = {
    val path = new File(getClass.getResource("/images").getPath)
    path
      .listFiles()
      .toSeq
      .map(_.getName)
      .map(fileName => ImageWithMeta(fileName, ImageIO.read(new File(s"$path/$fileName"))))
  }

  private def checkDiffPercentage(imageList: Seq[ImageWithMeta]): String = {
    val totalPixelCount = imageList.head.image.getWidth * imageList.head.image.getHeight
    var cumulativeDiff = 0
    for (y <- 0 until imageList.head.image.getHeight) {
      for (x <- 0 until imageList.head.image.getWidth) {
        if (isDifferentRGB(imageList.head.image, imageList(1).image, x, y)) {
          cumulativeDiff += 1
        }
      }
    }
    formatResult(cumulativeDiff, totalPixelCount)
  }

  private def isDifferentRGB(imageA: BufferedImage, imageB: BufferedImage, x: Int, y: Int): Boolean = {
    if (imageA.getRGB(x, y) != imageB.getRGB(x, y)) true
    else false
  }

  private def formatResult(cumulativeDiff: Int, totalPixelCount: Int): String = {
    val df = new DecimalFormat("##0.00")
    val diff = df.format((cumulativeDiff * 100.0f) / totalPixelCount)
    s"There is a $diff% difference between the given images"
  }
}
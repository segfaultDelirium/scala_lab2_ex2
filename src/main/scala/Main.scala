import scala.util.Random
import scala.compiletime.ops.boolean

case class Point(x: Double, y: Double) {}

object Point {
  def createRandomPoint(generator: Random) = {
    Point(generator.nextDouble(), generator.nextDouble())
  }
}

def calculateDistanceTo0(point: Point): Double = {
  math.sqrt(math.pow(point.x, 2) + math.pow(point.y, 2))
}

def isPointInsideCircle(point: Point): Boolean = {
  calculateDistanceTo0(point) < 1
}

def calculatePi(generator: Random, N: Int): Double = {
  val numberOfPointsInsideCircle = (0 to N).map(_i => {
    if isPointInsideCircle(Point.createRandomPoint(generator)) then 1 else 0
  }).reduce((acc, x) => acc + x)
  return numberOfPointsInsideCircle * 4.0 / N;
}

@main def main: Unit = {

  val generator = new Random();
  // val rand = generator.nextDouble();

  val samplePoint = Point.createRandomPoint(generator);

  println(s"sample point: ${samplePoint}");
  val pi = calculatePi(generator, 10000000);
  println(s"pi = ${pi}")

}

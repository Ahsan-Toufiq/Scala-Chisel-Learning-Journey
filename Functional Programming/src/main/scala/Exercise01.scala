object Exercise01 {

  def fibonacci (n : Int): Int = {

    def loop (n :Int ,acc : Int): Int = {
      if (n <= 1 ){
        1
      }
      else {
        loop(n-2,acc)+loop(n-1,acc)
      }

    }
    loop(n,1)
  }

  def main(args: Array[String]) = {
    for (i <- 0 to 9){
      println(fibonacci(i))
    }

  }
}

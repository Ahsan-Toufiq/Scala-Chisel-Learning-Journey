file://<WORKSPACE>/src/test/scala/practice/Lab01Ex01Test.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.

action parameters:
offset: 249
uri: file://<WORKSPACE>/src/test/scala/practice/Lab01Ex01Test.scala
text:
```scala
package practice

import chisel3._
import org.scalatest._
import chiseltest._

class Lab01Ex01Test extends FreeSpec with ChiselScalatestTester{
    "Lab#01 Exercise#01 Test" in{
        test(new(Counter_SInt(3))){ob1 =>
        ob1.io.result.expect(@@)}
    }

} 

```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:186)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:94)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:375)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0
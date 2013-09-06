# Yaffuts

Yet Another Framework For Unit Testing Scala

It looks like this: 
(Just like most xUnit test framework. If not, then it looks like in the scala way. :P)

	import yaffuts._

	class TestUnitTest extends Test {
	  test ("given assert fail execute should fail total increase") {
		val sut = new AssertFailTestClass

		sut.run()

		Assert.areEqual(sut.expectFailure, sut.failTotal)
	  }

	  test ("given throw null exception should fail total increase") {
		val sut = new ThrowNullExceptionTestClass

		sut.run()

		Assert.areEqual(sut.expectFailure, sut.failTotal)
	  }
	}

For detailed examples, please refer to yaffuts.selftest.

## License

	This program is free software. It comes without any warranty, to
	the extent permitted by applicable law. You can redistribute it
	and/or modify it under the terms of the Do What The Fuck You Want
	To Public License, Version 2, as published by Sam Hocevar. See
	http://sam.zoy.org/wtfpl/COPYING for more details.

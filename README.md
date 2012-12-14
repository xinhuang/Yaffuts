Yaffuts: Yet Another Framework For Unit Testing Scala

It looks like this: 
(Just like most xUnit test framework. If not, then it will be. :P)

	import yaffuts.{TestMethods, Test}

	class TestUnitTest extends Test {

	  override val testMethods: TestMethods = new TestMethods(
		("given_assert_fail_execute_should_fail_total_increase", 
		given_assert_fail_execute_should_fail_total_increase _),
		("given_throw_null_exception_should_fail_total_increase", given_throw_null_exception_should_fail_total_increase _)
	  )


	  def given_assert_fail_execute_should_fail_total_increase() {
		val sut = new AssertFailTestClass

		sut.run()

		Assert.areEqual(sut.expectFailure, sut.failTotal)
	  }

	  def given_throw_null_exception_should_fail_total_increase() {
		val sut = new ThrowNullExceptionTestClass

		sut.run()

		Assert.areEqual(sut.expectFailure, sut.failTotal)
	  }
	}

For detailed examples, please refer to yaffutsTest project, which use yaffuts to bootstrap itself.

------------
License

	This program is free software. It comes without any warranty, to
	the extent permitted by applicable law. You can redistribute it
	and/or modify it under the terms of the Do What The Fuck You Want
	To Public License, Version 2, as published by Sam Hocevar. See
	http://sam.zoy.org/wtfpl/COPYING for more details.
// !CHECK_TYPE

val x get() = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>x<!>

class A {
    val y get() = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>y<!>

    val a get() = <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>b<!>
    val b get() = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!>a<!>

    val z1 get() = id(<!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM, DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>z1<!>)
    val z2 get() = l(<!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM, DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>z2<!>)

    val u get() = <!UNRESOLVED_REFERENCE!>field<!>
}

fun <E> id(x: E) = x
fun <E> l(<!UNUSED_PARAMETER!>x<!>: E): List<E> = null!!

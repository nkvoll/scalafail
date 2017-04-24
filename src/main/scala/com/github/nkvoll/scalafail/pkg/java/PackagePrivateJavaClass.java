package com.github.nkvoll.scalafail.pkg.java;

/**
 * A package private class, shouldn't be possible to hold a reference to this class outside of this package :)
 */
final class PackagePrivateJavaClass {
    public void sayHello() {
        System.out.println("hello from " + this);
    }
}

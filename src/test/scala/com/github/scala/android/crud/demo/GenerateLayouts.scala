package com.github.scala.android.crud.demo

import com.github.scala.android.crud.generate.CrudUIGenerator

/**
 * A layout generator for the application.
 * @author Eric Pabst (epabst@gmail.com)
 */

object GenerateLayouts {
  def main(args: Array[String]) {
    CrudUIGenerator.generateLayouts(DemoApplication)
  }
}
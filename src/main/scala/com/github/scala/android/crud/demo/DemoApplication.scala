package com.github.scala.android.crud.demo

import com.github.scala.android.crud.{CrudType, CrudBackupAgent, CrudApplication}

/**
  * The Demo of scala-android-crud application.
  */

object DemoApplication extends CrudApplication {
  val name = "Demo of scala-android-crud"

  def allEntities = List[CrudType](GroupCrudType) //TODO Add other entities here
}

/**
  *  The Backup Agent that works with the Google Android Backup Service.
  */ 
class DemoBackupAgent extends CrudBackupAgent(DemoApplication)

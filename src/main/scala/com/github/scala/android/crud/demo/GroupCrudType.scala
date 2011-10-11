package com.github.scala.android.crud.demo

import com.github.scala.android.crud._
import persistence.CursorField._
import view.ViewField._
import persistence.PersistedType._

/**
 * A CRUD type for Group.
 */

object GroupCrudType extends CrudType with SQLiteCrudType {
  def entityName = "Group"

  def valueFields = List(
    persisted[String]("name") + viewId(classOf[R], "name", textView)
  )

  def activityClass = classOf[GroupActivity]
  def listActivityClass = classOf[GroupListActivity]

  def cancelItemString = res.R.string.cancel_item
  def editItemString = R.string.edit_group
  def addItemString = R.string.add_group
}

class GroupListActivity extends CrudListActivity(GroupCrudType, DemoApplication)
class GroupActivity extends CrudActivity(GroupCrudType, DemoApplication)
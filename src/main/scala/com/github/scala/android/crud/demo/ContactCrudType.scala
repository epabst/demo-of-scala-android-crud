package com.github.scala.android.crud.demo

import com.github.scala.android.crud._
import persistence.CursorField._
import view.ViewField._
import persistence.PersistedType._
import ParentField._

/**
 * A CRUD type for Contact.
 */

object ContactCrudType extends CrudType with SQLiteCrudType {
  def entityName = "Contact"

  def valueFields = List(
    foreignKey(GroupCrudType),
    persisted[String]("name") + viewId(classOf[R], "name", textView)
  )

  def activityClass = classOf[ContactActivity]
  def listActivityClass = classOf[ContactListActivity]

  def cancelItemString = res.R.string.cancel_item
  def editItemString = R.string.edit_entity
  def addItemString = R.string.add_entity
}

class ContactListActivity extends CrudListActivity(ContactCrudType, DemoApplication)
class ContactActivity extends CrudActivity(ContactCrudType, DemoApplication)

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
}

class ContactListActivity extends CrudListActivity(ContactCrudType, DemoApplication)
class ContactActivity extends CrudActivity(ContactCrudType, DemoApplication)

package com.github.scala.android.crud.demo

import com.github.scala.android.crud._
import persistence.CursorField._
import view.ViewField._
import persistence.PersistedType._
//import java.util.Date
//import com.github.scala.android.crud.ParentField._

/**
 * A CRUD type for Contact.
 */

object ContactCrudType extends CrudType with SQLiteCrudType {
  def entityName = "Contact"

  def valueFields = List(
    persisted[String]("name") + viewId(classOf[R], "name", textView) /*,

    here are some sample fields

    foreignKey(OtherCrudType),

    persisted[MyEnum.Value]("myFieldName")(enumStringType[MyEnum.Value](MyEnum)) +
          viewId(classOf[R], "myFieldName", enumerationView(MyEnum)),

    persisted[Int]("myIntField") + viewId(classOf[R], "myIntField", intView),

    persisted[Date]("myDateField") +
      viewId[Date](classOf[R], "myDateField", dateView)
  */
  )

  def activityClass = classOf[ContactActivity]
  def listActivityClass = classOf[ContactListActivity]

  def cancelItemString = res.R.string.cancel_item
  def editItemString = R.string.edit_entity
  def addItemString = R.string.add_entity
}

class ContactListActivity extends CrudListActivity(ContactCrudType, DemoApplication)
class ContactActivity extends CrudActivity(ContactCrudType, DemoApplication)

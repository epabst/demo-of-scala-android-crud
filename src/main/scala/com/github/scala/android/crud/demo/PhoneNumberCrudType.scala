package com.github.scala.android.crud.demo

import com.github.scala.android.crud._
import persistence.CursorField._
import view.ViewField._
import persistence.PersistedType._
//import java.util.Date
//import com.github.scala.android.crud.ParentField._

/**
 * A CRUD type for PhoneNumber.
 */

object PhoneNumberCrudType extends CrudType with SQLiteCrudType {
  def entityName = "PhoneNumber"

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

  def activityClass = classOf[PhoneNumberActivity]
  def listActivityClass = classOf[PhoneNumberListActivity]

  def cancelItemString = res.R.string.cancel_item
  def editItemString = R.string.edit_entity
  def addItemString = R.string.add_entity
}

class PhoneNumberListActivity extends CrudListActivity(PhoneNumberCrudType, DemoApplication)
class PhoneNumberActivity extends CrudActivity(PhoneNumberCrudType, DemoApplication)

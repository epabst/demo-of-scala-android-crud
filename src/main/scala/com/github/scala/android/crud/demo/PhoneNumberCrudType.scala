package com.github.scala.android.crud.demo

import com.github.scala.android.crud._
import persistence.CursorField._
import view.ViewField._
import persistence.PersistedType._
import com.github.scala.android.crud.ParentField._

/**
 * A CRUD type for PhoneNumber.
 */

object PhoneNumberCrudType extends CrudType with SQLiteCrudType {
  def entityName = "PhoneNumber"

  val phoneNumberField = persisted[String]("phoneNumber") + 
          viewId(classOf[R], "phoneNumber", textViewWithInputType("phone"))

  def valueFields = List(
    foreignKey(ContactCrudType),
    persisted("type")(enumStringType[PhoneType.Value](PhoneType)) + viewId(classOf[R], "type", enumerationView(PhoneType)),
    persisted[String]("phoneNumber") + viewId(classOf[R], "phoneNumber", phoneView)
  )

  def activityClass = classOf[PhoneNumberActivity]
  def listActivityClass = classOf[PhoneNumberListActivity]

  def cancelItemString = res.R.string.cancel_item
  def editItemString = R.string.edit_phone_number
  def addItemString = R.string.add_phone_number
}

object PhoneType extends Enumeration {
  val Home = Value("Home")
  val Mobile = Value("Cell")
  val Work = Value("Work")
  val Pager = Value("Pager")
  val Other = Value("Other")
}

class PhoneNumberListActivity extends CrudListActivity(PhoneNumberCrudType, DemoApplication)
class PhoneNumberActivity extends CrudActivity(PhoneNumberCrudType, DemoApplication)

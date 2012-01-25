package com.github.scala.android.crud.demo

import com.github.scala.android.crud._
import action.{ActivityWithVars, UriPath, StartActivityAction}
import persistence.CursorField._
import view.ViewField._
import persistence.PersistedType._
import com.github.scala.android.crud.ParentField._
import android.content.Intent
import android.net.Uri

/**
 * A CRUD type for PhoneNumber.
 */

object PhoneNumberCrudType extends CrudType with SQLiteCrudType {
  def entityName = "PhoneNumber"

  val phoneNumberField = persisted[String]("phoneNumber") + 
          viewId(classOf[R], "phoneNumber", textViewWithInputType("phone"))

  def valueFields = List(
    foreignKey(ContactCrudType),
    persistedEnum[PhoneType.Value]("type", PhoneType) + viewId(classOf[R], "type", enumerationView(PhoneType)),
    phoneNumberField
  )


  override def getEntityActions(application: CrudApplication) =
    new StartActivityAction {
      def determineIntent(uri: UriPath, activity: ActivityWithVars) =
        withEntityPersistence(new CrudContext(activity, application), { persistence =>
          val phoneNumberEntity = persistence.findAll(uri).head
          val url = "tel:" + phoneNumberField.apply(phoneNumberEntity)
          new Intent(Intent.ACTION_CALL, Uri.parse(url))
        })
      def icon = None
      def title = None
    } +: super.getEntityActions(application)

  def activityClass = classOf[PhoneNumberActivity]
  def listActivityClass = classOf[PhoneNumberListActivity]
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

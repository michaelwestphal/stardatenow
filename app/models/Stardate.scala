package models

import org.joda.time.DateTime

/**
 *
 * @param instant
 */
case class Stardate(instant: DateTime) {
	override def toString(): String = instant.toString("yyyy.D")
	def day = instant.getDayOfMonth
	def month = instant.monthOfYear().getAsShortText
	def year = instant.year().get()
}

object Stardate {
  def now = Stardate(DateTime.now())

  /**
   *
   * @param yearMonthDay
   * @return
   */
  def at(yearMonthDay: String) = {
    Stardate( DateTime.parse(yearMonthDay) )
  }
}


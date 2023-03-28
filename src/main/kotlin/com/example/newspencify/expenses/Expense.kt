package com.example.newspencify.expenses

import jakarta.persistence.*
import org.springframework.data.jpa.repository.Temporal
import java.util.*


@Entity
@Table(name="expenses")
class Expenses (
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Int? = null,

   @Column(nullable = false,length = 45)
   var amount: Int = 0,

   @Column(nullable = false, length = 100)
   var description: String? = null,

   @Column(nullable = false, length = 100)
   var category: String? = null,

   @Column(nullable = false)
   var image: String? = null,

   @Column(name = "date", nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
   var date: Date? = null
) {

   fun getExpenseId(): Int? {
      return id
   }

   private fun getExpenseAmount(): Int {
      return amount
   }

   fun getExpenseDescription(): String? {
      return description
   }

   private fun getExpenseCategory(): String? {
      return category
   }

   private fun getExpenseImage(): String? {
      return image
   }

   private fun getExpenseDate(): Date? {
      return date
   }

   // setter methods
   private fun setGetExpenseId(newId: Int?) {
      id = newId
   }

   private fun setGetAmount(newAmount: Int) {
      amount = newAmount
   }

   private fun setGetDescription(newDescription: String?) {
      description = newDescription
   }

   private fun setGetCategory(newCategory: String?) {
      category = newCategory
   }

   private fun setGetImage(newImage: String?) {
      image = newImage
   }

   private fun setGetDate(newDate: Date?) {
      date = newDate
   }

   override fun toString(): String {
      return "Expenses{" +
              "id=$id" +
              ", description='$description'" +
              ", category=$category" +
              ", image=$image" +
              ", date=$date" +
              "}"
   }
}










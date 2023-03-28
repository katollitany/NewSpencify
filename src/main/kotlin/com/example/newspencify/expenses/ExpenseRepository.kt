package com.example.newspencify.expenses

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

//interface expenseRepository : CrudRepository< Expense, Id> {
//}
@Repository
interface ExpenseRepository : CrudRepository<Expenses,Int>{
    // interface methods here
    fun findByCategory(category: String): List<Expenses>

}

//    override fun findById(id: Int): Optional<Expenses>
//    override fun findAll(): List<Expenses>
//    override fun <S : Expenses?> save(entity: S & Any): S & Any
//    override fun delete(expense: Expenses)

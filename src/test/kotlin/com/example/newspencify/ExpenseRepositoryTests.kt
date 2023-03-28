package com.example.newspencify

import com.example.newspencify.expenses.ExpenseRepository
import com.example.newspencify.expenses.Expenses
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Rollback
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import java.util.*


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class ExpenseRepositoryTests {
    @Autowired
    lateinit var repo: ExpenseRepository

    @Test
    fun testAddExpense() {
        val newExpense = Expenses()
        newExpense.amount = 40
        newExpense.description = "Food for clients"
        newExpense.category = "Food"
        newExpense.image="https://rb.gy/ojufv0"
        newExpense.date = Date()
        val savedExpense = repo.save(newExpense)


        println(savedExpense)

        Assertions.assertThat(savedExpense).isNotNull
        Assertions.assertThat(savedExpense.getExpenseId()).isGreaterThan(0)
    }

    @Test
    fun testFindAll() {
        val expenses: Iterable<Expenses> = repo.findAll()
        assertThat(expenses).hasSizeGreaterThan(0)

        for (expense in expenses) {
            println(expense)
        }
    }

    @Test
    fun testUpdatingExpense() {
        val userId: Int = 1
        val findExpenseID = repo.findById(userId)
        val expense: Expenses = findExpenseID.get()
        expense.amount = 3
        repo.save(expense)

        val updatedExpense: Expenses = repo.findById(userId).get()
        Assertions.assertThat(updatedExpense.amount).isEqualTo(3)
    }

    @Test
    fun testGetExpenses() {
        val userId: Int = 7;
        val findExpenseID = repo.findById(userId);

        Assertions.assertThat(findExpenseID).isPresent
        println("loreto" + findExpenseID.get())
    }


}






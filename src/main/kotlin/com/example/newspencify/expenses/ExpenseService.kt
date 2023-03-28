package com.example.newspencify.expenses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ExpenseService {
    @Autowired
    private lateinit var repo: ExpenseRepository
}


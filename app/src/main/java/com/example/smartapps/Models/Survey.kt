package com.example.smartapps.Models

data class Survey(
    val user: Int,
    val name: String,
    val job: String,
    val income: String,
    val foodExpense: String,
    val educationExpense: String,
    val healthExpense: String,
    val transportationTaxExpense: String,
    val pbbTaxExpense: String,
    val electricityExpense: String,
    val financialServiceAccess: Boolean,
    val healthServiceAccess: Boolean,
    val governmentAssistance: Boolean,
    val economicLevel: String
)


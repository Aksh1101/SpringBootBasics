package org.example.springbootbasics

class QuoteNotFoundException(
    private val quoteId: Long,
): RuntimeException(
    "Quote not found for ID $quoteId"
)

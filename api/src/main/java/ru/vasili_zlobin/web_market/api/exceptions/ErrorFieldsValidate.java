package ru.vasili_zlobin.web_market.api.exceptions;

import java.util.List;

public record ErrorFieldsValidate(List<String> messages) {
}

package org.library.services;

import org.library.entities.LibraryCard;
import org.library.repositories.LibraryCardRepository;

import java.time.LocalDate;

class Util {

    static LibraryCard generateLibraryCard(LibraryCardRepository libraryCardRepository) {
        LocalDate date = LocalDate.now();
        StringBuilder sb = new StringBuilder();
        sb.append(date.getYear())
                .append(check2digits(date));
        long count = libraryCardRepository.countAllByNumberContaining(sb.toString());
        return new LibraryCard(generateLibraryCardNum(sb, count));
    }

    private static String generateLibraryCardNum(StringBuilder num, long periodCount) {
        String count = periodCount + "";
        num.append("00000");
        num.replace(num.length()-count.length(),num.length(),count);
        return num.toString();
    }

    private static String check2digits(LocalDate date) {
        int monthValue = date.getMonthValue();
        return monthValue < 10 ? "0" + monthValue : monthValue + "";
    }
}

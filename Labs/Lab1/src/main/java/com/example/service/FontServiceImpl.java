package com.toleyko.service;

public class FontServiceImpl implements FontService {
    @Override
    public String[] generateRows(int amount) {
        String[] res = new String[amount];

        for (int i = 0; i < amount; i++) {
            StringBuilder row = new StringBuilder();
            int wordsInThisRowAmount = (int) ((Math.random() * (6 - 2)) + 2);

            for (int j = 0; j < wordsInThisRowAmount; j++) {
                StringBuilder word = new StringBuilder();
                int chInThisWordAmount = (int) ((Math.random() * (6 - 2)) + 2);

                for (int k = 0; k < chInThisWordAmount; k++) {
                    String ch = Character.toString(((int) ((Math.random() * (122 - 97)) + 97)));
                    word.append(ch);
                }
                row.append(word.toString().toLowerCase());
                row.append(" ");
            }
            row.append("\n");
            System.out.println(row);
            res[i] = row.toString();
        }
        return res;
    }
}

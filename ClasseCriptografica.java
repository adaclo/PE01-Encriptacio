public class ClasseCriptografica {

    public String encripta(String missatge, String clau) {
        int numKey = 0;
        try {
            numKey = Integer.parseInt(clau);
        } catch (Exception e) {
            System.out.println("(!) Error al llegir la clau numèrica.");
        }

        char[] caracters = missatge.toCharArray();

        // intercanviar caràcters de dos en dos
        for (int i = 0; i < caracters.length - 1; i += 2) {
            char temp = caracters[i];
            caracters[i] = caracters[i + 1];
            caracters[i + 1] = temp;
        }

        // aplicar desplaçament segons la posició (parell/imparell)
        for (int i = 0; i < caracters.length; i++) {
            if (i % 2 == 0) {
                caracters[i] = desplacar(caracters[i], numKey);
            } else {
                caracters[i] = desplacar(caracters[i], -numKey);
            }
        }

        String result = "";
        result = new String(caracters);
        return result;
    }

    public String desencripta(String missatge, String clau) {
        int numKey = 0;
        try {
            numKey = Integer.parseInt(clau);
        } catch (Exception e) {
            System.out.println("(!) Error al llegir la clau numèrica.");
        }

        char[] caracters = missatge.toCharArray();

        // invertir el desplaçament
        for (int i = 0; i < caracters.length; i++) {
            if (i % 2 == 0) {
                caracters[i] = desplacar(caracters[i], -numKey);
            } else {
                caracters[i] = desplacar(caracters[i], numKey);
            }
        }

        // invertir l'intercanvi de dos en dos
        for (int i = 0; i < caracters.length - 1; i += 2) {
            char temp = caracters[i];
            caracters[i] = caracters[i + 1];
            caracters[i + 1] = temp;
        }

        String result = "";
        result = new String(caracters);
        return result;
    }

    public char desplacar(char c, int k) {
        char res = c;
        if (c >= 'A' && c <= 'Z') {
            int pos = c - 'A';
            pos = (pos + k) % 26;
            if (pos < 0) {
                pos += 26;
            }
            res = (char) ('A' + pos);
        } else if (c >= 'a' && c <= 'z') {
            int pos = c - 'a';
            pos = (pos + k) % 26;
            if (pos < 0) {
                pos += 26;
            }
            res = (char) ('a' + pos);
        }
        return res;
    }
}
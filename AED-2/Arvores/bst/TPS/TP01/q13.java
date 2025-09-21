package TP01;
import java.io.*;
import java.net.*;
import java.util.*;

public class q13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String pageName = sc.nextLine();
        
        while (!(pageName.length() == 3 && pageName.charAt(0) == 'F' && pageName.charAt(1) == 'I' && pageName.charAt(2) == 'M')) {
            String url = sc.nextLine();
            
            try {
                String htmlContent = lerPagina(url);
                
                int[] vowelCounts = new int[22];
                int consonants = 0;
                int brCount = 0;
                int tableCount = 0;
                
                int length = htmlContent.length();
                
                for (int i = 0; i < length; i++) {
                    char c = htmlContent.charAt(i);
                    
                    switch (c) {
                        case 'a': vowelCounts[0]++; break;
                        case 'e': vowelCounts[1]++; break;
                        case 'i': vowelCounts[2]++; break;
                        case 'o': vowelCounts[3]++; break;
                        case 'u': vowelCounts[4]++; break;
                        case 'á': vowelCounts[5]++; break;
                        case 'é': vowelCounts[6]++; break;
                        case 'í': vowelCounts[7]++; break;
                        case 'ó': vowelCounts[8]++; break;
                        case 'ú': vowelCounts[9]++; break;
                        case 'à': vowelCounts[10]++; break;
                        case 'è': vowelCounts[11]++; break;
                        case 'ì': vowelCounts[12]++; break;
                        case 'ò': vowelCounts[13]++; break;
                        case 'ù': vowelCounts[14]++; break;
                        case 'ã': vowelCounts[15]++; break;
                        case 'õ': vowelCounts[16]++; break;
                        case 'â': vowelCounts[17]++; break;
                        case 'ê': vowelCounts[18]++; break;
                        case 'î': vowelCounts[19]++; break;
                        case 'ô': vowelCounts[20]++; break;
                        case 'û': vowelCounts[21]++; break;
                        default:
                            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                                char[] vowels = {'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'à', 'è', 'ì', 'ò', 'ù', 'ã', 'õ', 'â', 'ê', 'î', 'ô', 'û'};
                                char[] vowelsUpper = {'A', 'E', 'I', 'O', 'U', 'Á', 'É', 'Í', 'Ó', 'Ú', 'À', 'È', 'Ì', 'Ò', 'Ù', 'Ã', 'Õ', 'Â', 'Ê', 'Î', 'Ô', 'Û'};
                                boolean isVowel = false;
                                
                                for (char v : vowels) {
                                    if (c == v) {
                                        isVowel = true;
                                        break;
                                    }
                                }
                                
                                if (!isVowel) {
                                    for (char v : vowelsUpper) {
                                        if (c == v) {
                                            isVowel = true;
                                            break;
                                        }
                                    }
                                }
                                
                                if (!isVowel) {
                                    consonants++;
                                }
                            }
                            break;
                    }

                    if (i + 3 < length && htmlContent.charAt(i) == '<' && htmlContent.charAt(i + 1) == 'b' && htmlContent.charAt(i + 2) == 'r' && htmlContent.charAt(i + 3) == '>') {
                        brCount++;
                        i += 3;
                    } else if (i + 5 < length && htmlContent.charAt(i) == '<' && htmlContent.charAt(i + 1) == 't' && htmlContent.charAt(i + 2) == 'a' && htmlContent.charAt(i + 3) == 'b' && htmlContent.charAt(i + 4) == 'l' && htmlContent.charAt(i + 5) == 'e' && htmlContent.charAt(i + 6) == '>') {
                        tableCount++;
                        i += 5;
                    }
                }

                System.out.print("a(" + vowelCounts[0] + ") ");
                System.out.print("e(" + vowelCounts[1] + ") ");
                System.out.print("i(" + vowelCounts[2] + ") ");
                System.out.print("o(" + vowelCounts[3] + ") ");
                System.out.print("u(" + vowelCounts[4] + ") ");
                System.out.print("á(" + vowelCounts[5] + ") ");
                System.out.print("é(" + vowelCounts[6] + ") ");
                System.out.print("í(" + vowelCounts[7] + ") ");
                System.out.print("ó(" + vowelCounts[8] + ") ");
                System.out.print("ú(" + vowelCounts[9] + ") ");
                System.out.print("à(" + vowelCounts[10] + ") ");
                System.out.print("è(" + vowelCounts[11] + ") ");
                System.out.print("ì(" + vowelCounts[12] + ") ");
                System.out.print("ò(" + vowelCounts[13] + ") ");
                System.out.print("ù(" + vowelCounts[14] + ") ");
                System.out.print("ã(" + vowelCounts[15] + ") ");
                System.out.print("õ(" + vowelCounts[16] + ") ");
                System.out.print("â(" + vowelCounts[17] + ") ");
                System.out.print("ê(" + vowelCounts[18] + ") ");
                System.out.print("î(" + vowelCounts[19] + ") ");
                System.out.print("ô(" + vowelCounts[20] + ") ");
                System.out.print("û(" + vowelCounts[21] + ") ");
                System.out.print("consoante(" + consonants + ") ");
                System.out.print("<br>(" + brCount + ") ");
                System.out.print("<table>(" + tableCount + ") ");
                System.out.println(pageName);
                
            } catch (IOException e) {
                System.out.println("Erro ao acessar a página: " + url);
            }
            
            pageName = sc.nextLine();
        }
        
        sc.close();
    }

    private static String lerPagina(String url) throws IOException {
        URL website = new URL(url);
        
        // Forçando o uso de UTF-8 ao ler o conteúdo
        InputStreamReader reader = new InputStreamReader(website.openStream(), "UTF-8");
        BufferedReader in = new BufferedReader(reader);
        
        StringBuilder content = new StringBuilder();
        String inputLine;
        
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        
        return content.toString();
    }
}

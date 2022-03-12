package programmer;

import java.util.Locale;

//2021 KAKAO BLIND RECUITMENT 신규 아이디 추천
public class NewIDRecommendation {
    public String solution(String new_id) {
        String recommendationId = "";
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        recommendationId = new_id.toLowerCase();

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        StringBuffer sb = new StringBuffer(recommendationId);
        for(int i = 0 ; i < sb.length() ; i++ ){
            if(isValidChar(sb.charAt(i))){
                sb.deleteCharAt(i);
                i--;
            }
        }
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while(sb.indexOf("..") != -1){
            int i = sb.indexOf("..");
            sb = sb.replace(i, i + 2, ".");
        }

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(sb.length() > 0) {
            if (sb.charAt(0) == '.') {
                sb.deleteCharAt(0);
            }
        }
        if(sb.length() > 0) {
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(sb.length() ==0){
                sb.append("a");
        }
        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(sb.length() >= 16) {
            sb = sb.delete(15,sb.length());
            if (sb.charAt(sb.length() - 1) =='.') {
                sb.deleteCharAt(sb.length()-1);
            }
        }
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(sb.length() <= 2){
            sb.append(sb.charAt(sb.length()-1));
        }
        recommendationId = sb.toString();

        return recommendationId;
    }

    private boolean isValidChar(char c) {
        if((!(c >= 'a' && c <= 'z') &&
                !(c >= 'A' && c <= 'Z')) &&
                !(c == '.' || c == '_' || c == '-')&&!(c >='0' && c<= '9'))
        {
            return true;
        }
        return false;
    }

//객체지향적으로 풀기
    public String solution2(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }

    public static void main(String[] args) {
        NewIDRecommendation a = new NewIDRecommendation();
        String id = "";
        String solution = a.solution(id);
        System.out.println("solution = " + solution);

    }
}

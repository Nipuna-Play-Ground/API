void main(){
    final String DATA = """
            5-Kasun Sampath-Galle,
            2-Amil Shantha-Panadura,
            10-Pradeep Kumara-Kandy,
            250-Ruwani-Matara,
            11-Supun-Panadura
            """;

   String dataCopy = DATA;

   dataCopy = dataCopy.replace("\n", "");
   int count = (dataCopy.length() - dataCopy.replace(",", "").length()) + 1;

   String ids = "", names = "", addresses = "";
   int commaIndex = 0;
   for (int rounds = 0; rounds < count; rounds++){
       String studentDetails = dataCopy.substring(commaIndex, (rounds == count - 1 ? dataCopy.length() : dataCopy.indexOf(',', commaIndex)));

       int firstHyphenIndex = studentDetails.indexOf('-');
       int lastHyphenIndex = studentDetails.lastIndexOf('-');
       String id = String.format("S%03d", Integer.parseInt(studentDetails.substring(0, firstHyphenIndex)));
       String name = studentDetails.substring(++firstHyphenIndex, lastHyphenIndex);
       String address = studentDetails.substring(++lastHyphenIndex, studentDetails.length());

       ids += STR."\{id},";
       names += STR."\{name},";
       addresses += STR."\{address},";


       commaIndex = dataCopy.indexOf(',', commaIndex) + 1;
   }

    System.out.println(ids);
    System.out.println(names);
    System.out.println(addresses);
}
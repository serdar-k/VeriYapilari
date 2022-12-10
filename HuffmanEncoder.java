import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanEncoder{

    private static final int ALFABE_BOYUTU = 256;

    public HuffmanEncodedSonuc compress(final String data){

        final int[] frekans = FrekansTablosu(data);
        final Node root = buildHuffmanTree(frekans);
        final Map<Character, String> lookupTable = buildLookupTable(root);

        return new HuffmanEncodedSonuc(generateEncodedData(data, lookupTable), root);
    }


    private static String generateEncodedData(final String data, final Map<Character, String> lookupTable){
        final StringBuilder builder = new StringBuilder();

        for(final char karakter : data.toCharArray()){
            builder.append(lookupTable.get(karakter));
        }

        return builder.toString();
    }


    private static Map<Character, String> buildLookupTable(final Node root){

        final Map<Character, String> lookupTable = new HashMap<>();

        buildLookupTableImpl(root, "", lookupTable);

        return lookupTable;

    }

    private static void buildLookupTableImpl(final Node node, final String s, final Map<Character, String> lookupTable){

        if(!node.isLeaf()){
            buildLookupTableImpl(node.solCocuk, s + '0', lookupTable);
            buildLookupTableImpl(node.sagCocuk, s + '1', lookupTable);

        }else{
            lookupTable.put(node.karakter, s);
        }

    }


    private static Node buildHuffmanTree(int[] frekans){

        final PriorityQueue<Node> PQ = new PriorityQueue<>();

        for(char i = 0; i < ALFABE_BOYUTU; i++){
            if(frekans[i] > 0){
                PQ.add(new Node(i, frekans[i], null, null));
            }
        }

        if(PQ.size() == 1){
            PQ.add(new Node ('\0', 1, null, null));
        }

        while(PQ.size() > 1){
            final Node sol = PQ.poll();
            final Node sag = PQ.poll();
            final Node parent = new Node('\0', sol.frekans + sag.frekans, sol, sag);
            PQ.add(parent);
        }

        return PQ.poll();

    }

    private static int[] FrekansTablosu(final String data){

        final int[] frekans = new int[ALFABE_BOYUTU];

        for(final char karakter : data.toCharArray()){
            frekans[karakter]++;
        }

        return frekans;
    }

    public String decompress(final HuffmanEncodedSonuc result){
        return null;
    }

    static class Node implements Comparable<Node>{
        private final char karakter;
        private final int frekans;
        private final Node solCocuk;
        private final Node sagCocuk;

        private Node(final char karakter, final int frekans, final Node solCocuk, final Node sagCocuk){
            this.karakter = karakter;
            this.frekans = frekans;
            this.solCocuk = solCocuk;
            this.sagCocuk = sagCocuk;
        }

        boolean isLeaf(){
            return this.solCocuk == null && this.sagCocuk == null;
        }

        @Override
        public int compareTo(final Node node){

            final int frekansKarsilastir = Integer.compare(this.frekans, node.frekans);

            if(frekansKarsilastir != 0){
                return frekansKarsilastir;
            }

            return Integer.compare(this.karakter, node.karakter);
        }


    }

    static class HuffmanEncodedSonuc{

        final Node root;
        final String encodedData;

        HuffmanEncodedSonuc(final String encodedData, final Node root){
            this.encodedData = encodedData;
            this.root = root;
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kodlanacak Kelimeyi Girin: ");
        String string = scanner.next();
//        final String test = "";
        final HuffmanEncoder encoder = new HuffmanEncoder();
        final HuffmanEncodedSonuc sonuc = encoder.compress(string);
        System.out.println("Kodlanmis Kelime: ");
        System.out.println(sonuc.encodedData);

        // final int[] frekansTablosu = FrekansTablosu(test);
        // final Node node = buildHuffmanTree(frekansTablosu);
        // final Map<Character, String> lookup = buildLookupTable(node)
//        System.out.println(frekansTablosu);

    }
}
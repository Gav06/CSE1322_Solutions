package Assignment5;

public class DNALib {

    public static boolean validator(String in) {
        if (in.isEmpty() || in.length() % 3 != 0)
            return false;

        // check chars in groups of 3 (codon size is 3 nucleobases)
        // even though we use a loop, we should still be within the rules of the assignment, as we use recursion
        for (int i = 0; i < 3; i++) {
            char c = in.charAt(i);
            if (!(c == 'A' || c == 'C' || c == 'G' || c == 'T'))
                return false;
        }

        // if we successfully traversed the last block, we know the string must be good
        if (in.length() == 3)
            return true;

        return validator(in.substring(3));
    }

    public static String reverser(String in) {
        if (in == null || in.length() <= 1)
            return in;

        return in.charAt(in.length() - 1) + reverser(in.substring(0, in.length() - 1));
    }

    public static String inverser(String in) {
        if (in == null || in.isEmpty())
            return in;

        return inverse(in.charAt(0)) + inverser(in.substring(1));
    }

    public static String translator(String in) {
        // base case, nullify if requirements are not met
        if (in.isEmpty() || in.length() % 3 != 0)
            return in;

        return codonToAmino(in.substring(0, 3)) + translator(in.substring(3));
    }

    private static String codonToAmino(String in) {
        switch(in) {
        case "GCA":
        case "GCC":
        case "GCG":
        case "GCT":
            return "A";
        case "TGC":
        case "TGT":
            return "C";
        case "GAC":
        case "GAT":
            return "D";
        case "GAA":
        case "GAG":
            return "E";
        case "TTC":
        case "TTT":
            return "F";
        case "GGA":
        case "GGC":
        case "GGG":
        case "GGT":
            return "G";
        case "CAC":
        case "CAT":
            return "H";
        case "ATA":
        case "ATC":
        case "ATT":
            return "I";
        case "AAA":
        case "AAG":
            return "K";
        case "CTA":
        case "CTC":
        case "CTG":
        case "CTT":
        case "TTA":
        case "TTG":
            return "L";
        case "ATG":
            return "M";
        case "AAT":
        case "AAC":
            return "N";
        case "CCA":
        case "CCC":
        case "CCG":
        case "CCT":
            return "P";
        case "CAA":
        case "CAG":
            return "Q";
        case "AGA":
        case "AGG":
        case "CGA":
        case "CGC":
        case "CGG":
        case "CGT":
            return "R";
        case "AGC":
        case "AGT":
        case "TCA":
        case "TCC":
        case "TCG":
        case "TCT":
            return "S";
        case "ACA":
        case "ACC":
        case "ACG":
        case "ACT":
            return "T";
        case "GTA":
        case "GTC":
        case "GTG":
        case "GTT":
            return "V";
        case "TGG":
            return "W";
        case "TAC":
        case "TAT":
            return "Y";
        case "TAA":
        case "TAG":
        case "TGA":
            return "-";
        }

        // return null if no amino acid is found
        return null;
    }

    private static char inverse(char in) {
        switch (in) {
            case 'A': return 'T';
            case 'C': return 'G';
            case 'G': return 'C';
            case 'T': return 'A';
            default:
                return 0;
        }
    }
}

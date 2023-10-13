import java.util.*;

public class UniquesDupes
{
    public Set<String> getUniques(String input)
    {
        Set<String> uniques = new TreeSet<String>();

        String[] set = input.split(" ");
        for (int x = 0; x < input.length(); x++)
        {
            uniques.add(set[x]);
        }
        return uniques;
    }
    public Set<String> getDupes(String input)
    {
        Set<String> help = new TreeSet<String>();
        Set<String> dupes = new TreeSet<String>();

        String[] set = input.split(" ");
        for (int x = 0; x < input.length(); x++) {
            if (!help.add(set[x])) {
                dupes.add(set[x]);
            }
            help.add(set[x]);
        }
        return dupes;
    }}

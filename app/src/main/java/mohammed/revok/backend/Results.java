package mohammed.revok.backend;

import java.util.List;

/**
 * Created by gmgn on 2/13/2017.
 */

public class Results {
    public List<String> derivation;

    private List<String> hasTypes;

    private String definition;

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    private List<String>synonyms;
    private List<String>usageOf;

    public List<String> getUsageOf() {
        return usageOf;
    }

    public void setUsageOf(List<String> usageOf) {
        this.usageOf = usageOf;
    }

    private List<String> typeOf;

    private List<String> examples;

    private String partOfSpeech;


    public List<String> getDerivation() {
        return derivation;
    }

    public void setDerivation(List<String> derivation) {
        this.derivation = derivation;
    }

    public List<String> getHasTypes() {
        return hasTypes;
    }

    public void setHasTypes(List<String> hasTypes) {
        this.hasTypes = hasTypes;
    }

    public List<String> getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(List<String> typeOf) {
        this.typeOf = typeOf;
    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public String getDefinition ()
    {
        return definition;
    }

    public void setDefinition (String definition)
    {
        this.definition = definition;
    }



    public String getPartOfSpeech ()
    {
        return partOfSpeech;
    }

    public void setPartOfSpeech (String partOfSpeech)
    {
        this.partOfSpeech = partOfSpeech;
    }

}

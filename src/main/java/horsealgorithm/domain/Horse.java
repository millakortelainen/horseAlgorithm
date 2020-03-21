package horsealgorithm.domain;

public class Horse{
private String name;
private String skillLevel;
private int height;
private String type;

public Horse(String name, String skillLevel, int height, String type){
    this.name = name;
    this.skillLevel = skillLevel;
    this.height = height;
    this.type = type;
}

public void setName(String name){
    this.name = name;
}

public void setSkillLevel(String skillLevel){
    this.skillLevel = skillLevel;
}

public void setHeight(int height){
    this.height = height;
}

public void setType(String type){
    this.type = type;
}

public String getName(){
    return this.name;
}

public String getSkillLevel(){
    return this.skillLevel;
}

public int getHeight(){
    return this.height;
}

public String getType(){
    return this.type;
}
public String toString(){
    return "HORSE INFO: \n"+
    "Name: "+this.name+"\n"+ 
    "Skill Level: "+this.skillLevel+"\n"+
    "Height: "+this.height+" cm \n"+
    "Type: "+this.type;
}

}
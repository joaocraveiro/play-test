package nodes;

import java.util.Set;

import org.neo4j.ogm.annotation.*;

@NodeEntity
public class SkillNode{

    public SkillNode(){}

    public SkillNode(String name){
        this.name = name;
    }

    @Id @GeneratedValue
	private Long id;

    @Property(name="entityId")
    public Long entityId;

	@Property(name="name")
 	public String name;

 	@Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    private Set<SkillNode> parent;

    @Relationship(type = "OWNS", direction = Relationship.OUTGOING)
    private Set<SkillNode> children;

    public Long getId(){
        return this.id;
    }

    public String getName(){return this.name; }

    public void save(){

    }

}
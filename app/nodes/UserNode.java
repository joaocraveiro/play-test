package nodes;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class UserNode {

	@Id @GeneratedValue
	private Long id;

	@Property(name="entityId")
	public Long entityId;

	@Property(name="firstname")
 	public String firstName;

	@Property(name="middlename")
	public String middleName;

	@Property(name="lastname")
	public String lastName;

 	@Relationship(type = PeerLink.TYPE, direction = Relationship.INCOMING)
    public Set<PeerLink> peers = new HashSet<>();

	public Long getId(){
		return this.id;
	}

	public void addPeer(UserNode peer){
		this.peers.add(new PeerLink(this, peer));
	}

	public void giveFeedback(UserNode target){
		//this
	}

}
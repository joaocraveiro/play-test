package nodes;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import java.util.Date;

@RelationshipEntity(type = PeerLink.TYPE)
public class PeerLink {

	public static final String TYPE = "PEER";

	public PeerLink(){}

	public PeerLink(UserNode user, UserNode peer){
		this.user = user;
		this.peer = peer;
		this.startDate = new Date();
		this.lastDate = new Date();
	}

	@Id @GeneratedValue
	private Long id;

	@StartNode
	public UserNode user;

	@EndNode
	public UserNode peer;

	@DateLong
	public Date startDate;

	@DateLong
	public Date lastDate;

	public Integer activityCount;

	public Integer followupCount;

	public Integer feedbackCount;

	public Float feedbackValue;

}
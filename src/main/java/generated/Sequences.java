/**
 * This class is generated by jOOQ
 */
package generated;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.system_sequence_271b216b_53cd_474b_929e_bd78fe96daeb</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_271B216B_53CD_474B_929E_BD78FE96DAEB = new SequenceImpl<Long>("system_sequence_271b216b_53cd_474b_929e_bd78fe96daeb", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

	/**
	 * The sequence <code>public.system_sequence_ebe55bf5_4147_4554_9fc1_aebb2d34218c</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_EBE55BF5_4147_4554_9FC1_AEBB2D34218C = new SequenceImpl<Long>("system_sequence_ebe55bf5_4147_4554_9fc1_aebb2d34218c", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}

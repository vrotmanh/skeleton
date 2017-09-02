/**
 * This class is generated by jOOQ
 */
package generated.tables;


import generated.Keys;
import generated.Public;
import generated.tables.records.ReceiptTagsRecord;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReceiptTags extends TableImpl<ReceiptTagsRecord> {

	private static final long serialVersionUID = -876652359;

	/**
	 * The reference instance of <code>public.receipt_tags</code>
	 */
	public static final ReceiptTags RECEIPT_TAGS = new ReceiptTags();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ReceiptTagsRecord> getRecordType() {
		return ReceiptTagsRecord.class;
	}

	/**
	 * The column <code>public.receipt_tags.id</code>.
	 */
	public final TableField<ReceiptTagsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.receipt_tags.uploaded</code>.
	 */
	public final TableField<ReceiptTagsRecord, Time> UPLOADED = createField("uploaded", org.jooq.impl.SQLDataType.TIME.defaulted(true), this, "");

	/**
	 * The column <code>public.receipt_tags.tag</code>.
	 */
	public final TableField<ReceiptTagsRecord, String> TAG = createField("tag", org.jooq.impl.SQLDataType.VARCHAR.length(150), this, "");

	/**
	 * The column <code>public.receipt_tags.receipt_id</code>.
	 */
	public final TableField<ReceiptTagsRecord, Integer> RECEIPT_ID = createField("receipt_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.receipt_tags</code> table reference
	 */
	public ReceiptTags() {
		this("receipt_tags", null);
	}

	/**
	 * Create an aliased <code>public.receipt_tags</code> table reference
	 */
	public ReceiptTags(String alias) {
		this(alias, RECEIPT_TAGS);
	}

	private ReceiptTags(String alias, Table<ReceiptTagsRecord> aliased) {
		this(alias, aliased, null);
	}

	private ReceiptTags(String alias, Table<ReceiptTagsRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ReceiptTagsRecord, Integer> getIdentity() {
		return Keys.IDENTITY_RECEIPT_TAGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ReceiptTagsRecord> getPrimaryKey() {
		return Keys.CONSTRAINT_3;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ReceiptTagsRecord>> getKeys() {
		return Arrays.<UniqueKey<ReceiptTagsRecord>>asList(Keys.CONSTRAINT_3);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReceiptTags as(String alias) {
		return new ReceiptTags(alias, this);
	}

	/**
	 * Rename this table
	 */
	public ReceiptTags rename(String name) {
		return new ReceiptTags(name, null);
	}
}

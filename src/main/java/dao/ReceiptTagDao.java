package dao;

import generated.tables.records.ReceiptTagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import static com.google.common.base.Preconditions.checkState;
import static generated.tables.ReceiptTags.RECEIPT_TAGS;

public class ReceiptTagDao {
    DSLContext dsl;

    public ReceiptTagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public int insert(String tag, int receiptId) {
        ReceiptTagsRecord receiptTagRecord = dsl
                .insertInto(RECEIPT_TAGS, RECEIPT_TAGS.TAG, RECEIPT_TAGS.RECEIPT_ID)
                .values(tag, receiptId)
                .returning(RECEIPT_TAGS.ID)
                .fetchOne();

        checkState(receiptTagRecord != null && receiptTagRecord.getId() != null, "Insert failed");

        return receiptTagRecord.getId();
    }
}

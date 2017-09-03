package dao;

import generated.tables.records.ReceiptTagsRecord;
import generated.tables.records.ReceiptsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.RECEIPTS;
import static generated.tables.ReceiptTags.RECEIPT_TAGS;

public class ReceiptTagDao {
    DSLContext dsl;

    public ReceiptTagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public int toggleTag(String tag, int receipId){
        Result<Record> results = dsl.select().from(RECEIPT_TAGS).where(RECEIPT_TAGS.RECEIPT_ID.equal(receipId)).and(RECEIPT_TAGS.TAG.equal(tag)).fetch();
        if(results.size() > 0){
            dsl.delete(RECEIPT_TAGS).where(RECEIPT_TAGS.ID.in(results.getValues(RECEIPT_TAGS.ID))).execute();
            return 0;
        }else{
            return insert(tag, receipId);
        }
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

    public List<ReceiptsRecord> getAllReceipts(String tag) {
        Result<Record1<Integer>> receiptIds = dsl.select(RECEIPT_TAGS.RECEIPT_ID).from(RECEIPT_TAGS).where(RECEIPT_TAGS.TAG.equal(tag)).fetch();
        return dsl.selectFrom(RECEIPTS).where(RECEIPTS.ID.in(receiptIds)).fetch();
    }

}

package controllers;

import api.ReceiptResponse;
import dao.ReceiptTagDao;
import generated.tables.records.ReceiptsRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("")
public class TagController {
    final ReceiptTagDao receiptTags;

    public TagController(ReceiptTagDao receiptTags) {this.receiptTags = receiptTags; }

    @Path("/tags/{tag}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void toggleTag(@PathParam("tag") String tagName, int reciptId) {
        receiptTags.toggleTag(tagName, reciptId);
    }

    @Path("/tags/{tag}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReceiptResponse> getReceipts(@PathParam("tag") String tagName) {
        List<ReceiptsRecord> receiptRecords = receiptTags.getAllReceipts(tagName);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }

}

package controllers;

import dao.ReceiptTagDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")
public class TagController {
    final ReceiptTagDao receiptTags;

    public TagController(ReceiptTagDao receiptTags) {this.receiptTags = receiptTags; }

    @Path("/tags/{tag}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void toggleTag(@PathParam("tag") String tagName) {
        System.out.println("");
        System.out.println("---------------TAG----------------");
        System.out.println(tagName);
        System.out.println("");
    }

}

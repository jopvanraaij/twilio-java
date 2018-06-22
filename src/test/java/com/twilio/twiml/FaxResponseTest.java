/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml;

import com.twilio.http.HttpMethod;
import com.twilio.twiml.fax.Receive;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * Test class for {@link FaxResponse}
 */
public class FaxResponseTest {
    @Test
    public void testEmptyElement() {
        FaxResponse elem = new FaxResponse.Builder().build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        FaxResponse elem = new FaxResponse.Builder().build();

        Assert.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CResponse%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithExtraAttributes() {
        FaxResponse elem = new FaxResponse.Builder().option("foo", "bar").option("a", "b").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithChildren() {
        FaxResponse.Builder builder = new FaxResponse.Builder();

        builder.receive(new Receive.Builder().action(URI.create("https://example.com")).method(HttpMethod.GET).build());

        FaxResponse elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response>" +
                "<Receive action=\"https://example.com\" method=\"GET\"/>" +
            "</Response>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        FaxResponse.Builder builder = new FaxResponse.Builder();

        builder.addText("Hey no tags!");

        FaxResponse elem = builder.build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response>" +
            "Hey no tags!" +
            "</Response>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        FaxResponse.Builder builder = new FaxResponse.Builder();
        FaxResponse elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</Response>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        FaxResponse.Builder builder = new FaxResponse.Builder();
        FaxResponse elem = builder.addChild(node).build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Response>" +
            "<genericTag key=\"value\">" +
            "someText" +
            "</genericTag>" +
            "</Response>",
            elem.toXml()
        );
    }
}
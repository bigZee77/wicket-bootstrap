package de.agilecoders.wicket.core.request.resource.caching.version;

import com.google.common.base.Charsets;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * helper class for {@link ChecksumResourceVersion} tests.
 *
 * @author miha
 */
abstract class ChecksumResourceVersionTest {

    protected abstract ChecksumResourceVersion newChecksumResourceVersion();

    protected void check(final String input, final String expected) {
        final ChecksumResourceVersion version = newChecksumResourceVersion();

        try {
            assertThat(new String(version.computeDigest(new ByteArrayInputStream(input.getBytes(Charsets.UTF_8)))), is(equalTo(expected)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

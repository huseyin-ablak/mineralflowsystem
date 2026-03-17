package be.kdg.prog6.warehousing.port.out;

/**
 * Represents raw profile picture data returned by the persistence adapter.
 *
 * <p>This record lives in the port layer rather than the domain because it carries
 * infrastructure-specific byte content. The domain does not need to know how
 * profile pictures are stored or transferred – it only cares that one exists.
 *
 * <p>Per ADR-2, if storage moves to an external service (S3/MinIO/Azure Blob),
 * this record would be replaced by a {@code ProfilePictureId} value object in the
 * domain, and the web adapter would resolve it to a URL.
 *
 * @param content     the image bytes
 * @param contentType the MIME type (e.g. {@code image/png})
 */
public record ProfilePicture(byte[] content, String contentType) {}

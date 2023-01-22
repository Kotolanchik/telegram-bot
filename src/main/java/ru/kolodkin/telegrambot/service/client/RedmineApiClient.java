package ru.kolodkin.telegrambot.service.client;

import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Attachment;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.kolodkin.telegrambot.bean.RedmineTransferFiles;
import ru.kolodkin.telegrambot.config.redmine.RedmineConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.apache.http.entity.ContentType.DEFAULT_BINARY;

@Slf4j
@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RedmineApiClient {
    RedmineManager globalRedmineManager;

    public RedmineApiClient(RedmineConfig redmineConfig) {
        globalRedmineManager = RedmineManagerFactory.createWithApiKey(redmineConfig.getUri(), redmineConfig.getKey());
    }

    public void getProjects() {

    }

    public void getProject() {

    }

    public void getIssue() {

    }

    public void getIssues() {

    }

    public void getUser() {
    }

    public void getUsers() {
    }

    public void createIssue() {
    }

    public void createProject() {

    }

    public void createUser() {

    }

    private Attachment getAttachmentFromBytes(final String nameFile, final byte[] content) throws RedmineException {
        try {
            return globalRedmineManager.getAttachmentManager()
                    .uploadAttachment(nameFile, DEFAULT_BINARY.getMimeType(), content);
        } catch (RedmineException | IOException exception) {
            throw new RedmineException(String.format("Файл %s не удалось конвертировать в Attachment. Проверьте файл.", nameFile));
        }
    }

    private List<Attachment> getAttachments(final RedmineTransferFiles transferFiles) {
        val attachmentList = new ArrayList<Attachment>();

        transferFiles.getFiles().forEach(transferFile -> {
            try {
                attachmentList.add(
                        getAttachmentFromBytes(
                                transferFile.getName(),
                                Base64.getDecoder().decode(transferFile.getEncodeByteContent()))
                );

            } catch (RedmineException exception) {
                throw new RuntimeException();
            }
        });

        return attachmentList;
    }
}

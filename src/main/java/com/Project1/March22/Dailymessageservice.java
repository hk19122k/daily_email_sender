package com.Project1.March22;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Dailymessageservice {

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(cron = "0 0 9 * * ?")
   
    public void sendDailyMessage() {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo("lathaharis8@gmail.com"); // change this
            helper.setSubject("🦚 Daily Reminder - " + getTodayDate());

            String content = buildStyledMessage();

            helper.setText(content, true); // true = HTML

            mailSender.send(message);

            System.out.println("Daily email sent successfully!");

        } catch (Exception e) {
            System.out.println("Error while sending email");
            e.printStackTrace();
        }
    }

    // 🔹 Styled HTML Content
    private String buildStyledMessage() {
        return """
        <html>
        <body style="margin:0; padding:0; background-color:#0f172a; font-family: 'Segoe UI', Arial, sans-serif; color:#e2e8f0;">

            <div style="max-width:600px; margin:40px auto; background:#1e293b; border-radius:12px; padding:30px; box-shadow:0 10px 30px rgba(0,0,0,0.5);">
                
                <h2 style="text-align:center; color:#38bdf8; margin-bottom:20px;">
                    🌟 Daily Reminder 🌟
                </h2>

                <p style="font-size:16px;">Always always <b>Believe in yourself</b>.</p>

                <p>
                The care everything first we need to keep for ourself alone, love yourself, dont overthink,
                if strikes PRAY believe in murugar.
                </p>

                <p>
                Always have a kind heart ❤️ but be <b>calm & patient</b> that sees many things.
                </p>

                <p style="color:#f87171;">
                Dont be a person who is kind outside and rude and angry within the family — this is literal bullshit.
                </p>

                <p>
                Whatever happens face it, feel it, energy is real ⚡
                </p>

                <p style="background:#0f172a; padding:10px; border-left:4px solid #38bdf8;">
                Consistent discipline will cause you more happiness than sudden dopamine clutch.
                </p>

                <p>
                Always forgive the insult once — if it continues mute yourself, walk away silently.
                </p>

                <p style="text-align:center; margin-top:20px;">
                🙏 <b>Always always be GRATEFUL for what I have</b><br/>
                Thank you Ayyappa
                </p>

                <hr style="border:none; border-top:1px solid #334155; margin:25px 0;">

                <p style="text-align:center; font-size:15px; color:#fbbf24;">
                <b>
                Finally don’t ever be the person I used to be.  
                Avoid that porno completely.  
                This time with God — see me.
                </b>
                </p>

            </div>

        </body>
        </html>
        """;
    }

    // 🔹 Dynamic Date
    private String getTodayDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }
}
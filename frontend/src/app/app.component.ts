import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { ResumeComponent } from './components/resume/resume.component';
import { CoverLetterComponent } from './components/cover-letter/cover-letter.component';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, SidebarComponent, ResumeComponent, CoverLetterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  isDarkMode = false;
  isGeneratingPdf = false;
  today = new Date();
  viewMode: 'resume' | 'cover-letter' = 'resume';

  ngOnInit(): void {
    if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
      this.isDarkMode = true;
    }
  }

  toggleDarkMode(): void {
    this.isDarkMode = !this.isDarkMode;
  }

  async downloadPDF() {
    this.isGeneratingPdf = true;
    const element = document.getElementById('pdf-container');
    
    if (element) {
      try {
        // Render the UI to canvas
        const canvas = await html2canvas(element, {
          scale: 2, // Higher resolution for crisp text
          useCORS: true,
          backgroundColor: this.isDarkMode ? '#0f172a' : '#ffffff' // slate-900 or white
        });
        
        const imgData = canvas.toDataURL('image/png');
        
        // Calculate dimensions (A4 width is ~210mm)
        const pdfWidth = 210;
        const pdfHeight = (canvas.height * pdfWidth) / canvas.width;
        
        // Use custom height to prevent cutting off text in the middle of a line
        const pdf = new jsPDF({
          orientation: 'portrait',
          unit: 'mm',
          format: [pdfWidth, pdfHeight]
        });

        pdf.addImage(imgData, 'PNG', 0, 0, pdfWidth, pdfHeight);
        
        const filename = this.viewMode === 'resume' ? 'Resume.pdf' : 'Cover_Letter.pdf';
        pdf.save(filename);
      } catch (error) {
        console.error('Error generating PDF', error);
        alert('Could not generate PDF. Please try again.');
      }
    }
    
    this.isGeneratingPdf = false;
  }
}
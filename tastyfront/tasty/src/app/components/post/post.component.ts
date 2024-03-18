import { Component } from '@angular/core';

@Component({
  selector: 'app-post',
  standalone: true,
  imports: [],
  templateUrl: './post.component.html',
  styleUrl: './post.component.css'
})
export class PostComponent {

  cardCount = [1, 2, 3]; // Array to iterate over for three cards

  constructor() { }
}

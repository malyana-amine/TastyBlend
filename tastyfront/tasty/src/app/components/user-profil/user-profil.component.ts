import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RequRes } from 'src/app/models/requ-res';
import { RequestsService } from 'src/app/services/requests/requests.service';

@Component({
  selector: 'app-user-profil',
  standalone: true,
  imports: [NgFor],
  templateUrl: './user-profil.component.html',
  styleUrl: './user-profil.component.css'
})
export class UserProfilComponent  implements OnInit {
  requests: RequRes[] | undefined;

  constructor(private requestsService: RequestsService) { }

  ngOnInit(): void {
    this.loadRequests();
  }

  loadRequests() {
    this.requestsService.getRequests().subscribe(
      (data: RequRes[]) => {
        this.requests = data;
      },
      (error) => {
        console.log('Error fetching requests: ', error);
      }
    );
  }

  acceptRequest(requestId: number) {
    this.requestsService.acceptRequest(requestId).subscribe(
      () => {
        console.log('Request accepted successfully');
        // Optionally, you can remove the accepted request from the UI
        this.requests = this.requests?.filter(request => request.id !== requestId);
      },
      (error) => {
        console.error('Error accepting request: ', error);
      }
    );
  }
  
  refuseRequest(requestId: number) {
    this.requestsService.refuseRequest(requestId).subscribe(
      () => {
        console.log('Request refused successfully');
        // Optionally, you can remove the refused request from the UI
        this.requests = this.requests?.filter(request => request.id !== requestId);
      },
      (error) => {
        console.error('Error refusing request: ', error);
      }
    );
  }
  
}
